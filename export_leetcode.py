#!/usr/bin/env python3
"""Export LeetCode CN solved problems and timestamps to CSV."""

import csv
import json
import ssl
import time
from urllib.request import Request, urlopen
from urllib.error import HTTPError, URLError

GRAPHQL_URL = "https://leetcode.cn/graphql/"
HEADERS = {
    "Content-Type": "application/json",
    "Origin": "https://leetcode.cn",
    "Referer": "https://leetcode.cn/progress/",
    "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
}

QUERY_PROFILE_QUESTIONS = """query userProfileQuestions($status: StatusFilterEnum!, $skip: Int!, $first: Int!, $sortField: SortFieldEnum!, $sortOrder: SortingOrderEnum!, $keyword: String, $difficulty: [DifficultyEnum!]) {
  userProfileQuestions(status: $status, skip: $skip, first: $first, sortField: $sortField, sortOrder: $sortOrder, keyword: $keyword, difficulty: $difficulty) {
    totalNum
    questions {
      translatedTitle
      frontendId
      titleSlug
      title
      difficulty
      lastSubmittedAt
      numSubmitted
      lastSubmissionSrc {
        sourceType
        ... on SubmissionSrcLeetbookNode {
          slug
          title
          pageId
          __typename
        }
        __typename
      }
      __typename
    }
    __typename
  }
}"""


def graphql_request(query, variables, cookies):
    payload = json.dumps({"query": query, "variables": variables}).encode()
    headers = {**HEADERS, "Cookie": cookies}
    req = Request(GRAPHQL_URL, data=payload, headers=headers, method="POST")
    ctx = ssl.create_default_context()
    for attempt in range(3):
        try:
            with urlopen(req, context=ctx) as resp:
                return json.loads(resp.read())
        except HTTPError as e:
            body = e.read().decode()
            if attempt < 2:
                print(f"HTTP {e.code}, retrying... ({body[:200]})")
                time.sleep(2)
            else:
                print(f"HTTP {e.code}: {body[:500]}")
                raise
        except URLError:
            if attempt < 2:
                time.sleep(2)
            else:
                raise


def main():
    session = input("LEETCODE_SESSION cookie: ").strip()
    csrf = input("x-csrftoken cookie: ").strip()
    cookies = f"LEETCODE_SESSION={session}; x-csrftoken={csrf}"

    print("Fetching solved problems...")
    data = graphql_request(
        QUERY_PROFILE_QUESTIONS,
        {"status": "ACCEPTED", "skip": 0, "first": 10000,
         "sortField": "LAST_SUBMITTED_AT", "sortOrder": "DESCENDING",
         "keyword": None, "difficulty": []},
        cookies,
    )

    questions = data["data"]["userProfileQuestions"]["questions"]
    total = data["data"]["userProfileQuestions"]["totalNum"]
    print(f"Found {total} solved problems.")

    output = "leetcode_solved.csv"
    with open(output, "w", newline="", encoding="utf-8") as f:
        writer = csv.writer(f)
        writer.writerow(["编号", "标题", "难度", "最后提交时间", "提交次数", "URL"])
        for q in questions:
            ts = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(q["lastSubmittedAt"]))
            url = f"https://leetcode.cn/problems/{q['titleSlug']}/"
            writer.writerow([
                q["frontendId"], q["translatedTitle"], q["difficulty"],
                ts, q["numSubmitted"], url,
            ])

    print(f"Done! Saved to {output}")


if __name__ == "__main__":
    main()
