//请你设计一个带光标的文本编辑器，它可以实现以下功能： 
//
// 
// 添加：在光标所在处添加文本。 
// 删除：在光标所在处删除文本（模拟键盘的删除键）。 
// 移动：将光标往左或者往右移动。 
// 
//
// 当删除文本时，只有光标左边的字符会被删除。光标会留在文本内，也就是说任意时候 0 <= cursor.position <= currentText.
//length 都成立。 
//
// 请你实现 TextEditor 类： 
//
// 
// TextEditor() 用空文本初始化对象。 
// void addText(string text) 将 text 添加到光标所在位置。添加完后光标在 text 的右边。 
// int deleteText(int k) 删除光标左边 k 个字符。返回实际删除的字符数目。 
// string cursorLeft(int k) 将光标向左移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的
//字符数目。 
// string cursorRight(int k) 将光标向右移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边
//的字符数目。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["TextEditor", "addText", "deleteText", "addText", "cursorRight", 
//"cursorLeft", "deleteText", "cursorLeft", "cursorRight"]
//[[], ["leetcode"], [4], ["practice"], [3], [8], [10], [2], [6]]
//输出：
//[null, null, 4, null, "etpractice", "leet", 4, "", "practi"]
//
//解释：
//TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
//textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
//textEditor.deleteText(4); // 返回 4
//                          // 当前文本为 "leet|" 。
//                          // 删除了 4 个字符。
//textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
//textEditor.cursorRight(3); // 返回 "etpractice"
//                           // 当前文本为 "leetpractice|". 
//                           // 光标无法移动到文本以外，所以无法移动。
//                           // "etpractice" 是光标左边的 10 个字符。
//textEditor.cursorLeft(8); // 返回 "leet"
//                          // 当前文本为 "leet|practice" 。
//                          // "leet" 是光标左边的 min(10, 4) = 4 个字符。
//textEditor.deleteText(10); // 返回 4
//                           // 当前文本为 "|practice" 。
//                           // 只有 4 个字符被删除了。
//textEditor.cursorLeft(2); // 返回 ""
//                          // 当前文本为 "|practice" 。
//                          // 光标无法移动到文本以外，所以无法移动。
//                          // "" 是光标左边的 min(10, 0) = 0 个字符。
//textEditor.cursorRight(6); // 返回 "practi"
//                           // 当前文本为 "practi|ce" 。
//                           // "practi" 是光标左边的 min(10, 6) = 6 个字符。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length, k <= 40 
// text 只含有小写英文字母。 
// 调用 addText ，deleteText ，cursorLeft 和 cursorRight 的 总 次数不超过 2 * 10⁴ 次。 
// 
//
// 
//
// 进阶：你能设计并实现一个每次调用时间复杂度为 O(k) 的解决方案吗？ 
//
// Related Topics 栈 设计 链表 字符串 双向链表 模拟 👍 67 👎 0


package leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DesignATextEditor{
    public static void main(String[] args) {
        TextEditor editor = new DesignATextEditor().new TextEditor();
        editor.addText("bxyackuncqzcqo");
        log.info(editor.cursorLeft(12));
        log.info(""+editor.deleteText(3));
        log.info(editor.cursorLeft(5));
        editor.addText("osdhyvqxf");
        log.info(editor.cursorRight(10));
    }
        //leetcode submit region begin(Prohibit modification and deletion)
    class TextEditor {

        private Node content;

        public TextEditor() {
            content = new Node("", 0);
        }

        public void addText(String text) {
            if (content.text.isEmpty()) {
                content.text = text;
                content.cursor = text.length();
                return;
            }
            if (content.cursor == 0) {
                Node pre = new Node(text, text.length());
                if (content.pre != null) {
                    content.pre.setNext(pre);
                }
                content.setPre(pre);
                content = pre;
                return;
            }
            if (content.cursor == content.text.length()) {
                Node next = new Node(text, text.length());
                if (content.next != null) {
                    next.next.setPre(next);
                }
                content.setNext(next);
                content = next;
                return;
            }
            Node pre = new Node(content.text.substring(0, content.cursor), content.cursor);
            Node middle = new Node(text, text.length());
            Node next = new Node(content.text.substring(content.cursor), 0);
            pre.setNext(middle);
            next.setPre(middle);
            if (content.pre != null) {
                content.pre.setNext(pre);
            }
            if (content.next != null) {
                content.next.setPre(next);
            }
            content = middle;
        }


        public int deleteText(int k) {
            //删除从 Max(cursor - k, 0) 到 cursor 的字符
            dels = 0;
            if (content.cursor >= k) {
                content.text = content.text.substring(0, content.cursor-k) + content.text.substring(content.cursor);
                content.cursor = content.cursor - k;
                return k;
            } else {
                if (content.pre == null) {
                    content.text = content.text.substring(content.cursor);
                    int d = content.cursor;
                    content.cursor = 0;
                    return d;
                } else {
                    dels += content.cursor;
                    content.cursor = 0;
                    Node pre = findNode(k - content.cursor, content.pre);
                    content.setPre(pre);
                    content = pre;
                    return dels;
                }
            }
        }

        int dels = 0;
        String lStr = "";

        private Node findNode(int k, Node n) {
            if (k < n.text.length()) {
                dels += k;
                n.cursor = n.text.length() - k;
                n.text = n.text.substring(0, n.cursor);
                return n;
            } else {
                dels += n.text.length();
                if (n.pre == null) {
                    n.text = "";
                    n.cursor = 0;
                    return n;
                } else {
                    return findNode(k - n.text.length(), n.pre);
                }
            }
        }

        public String cursorLeft(int k) {
            lStr = "";
            if (k > content.cursor) {
                Node n;
                if (content.pre != null) {
                    n = moveLeft(content.pre, k - content.cursor);
                } else {
                    n = content;
                }
                content.cursor = 0;
                content = n;
            } else {
                content.cursor -= k;
            }
            return strleft(content, 10);
        }

        public String cursorRight(int k) {
            lStr = "";
            if ((k + content.cursor) > content.text.length()) {
                Node n;
                if (content.next != null) {
                    n = moveRight(content.next, k - (content.text.length() - content.cursor));
                } else {
                    n = content;
                }
                content.cursor = content.text.length();
                content = n;
            }
            return strleft(content, 10);
        }

            private String strleft(Node n, int k) {
            if (n == null) {
                return lStr;
            } else if (k <= n.cursor) {
                lStr = n.text.substring(n.cursor - k, k) + lStr;
                return lStr;
            } else {
                lStr = (n.text.length() == n.cursor ? n.text : n.text.substring(0, n.cursor)) + lStr;
                return strleft(n.pre, k - n.cursor);
            }
        }

        private Node moveLeft(Node n, int k) {
            if (k > n.text.length()) {
                n.cursor = 0;
                if (n.pre == null) {
                    return n;
                } else {
                    return moveLeft(n.pre, k - n.text.length());
                }
            } else {
                n.cursor = n.text.length() - k;
                return n;
            }
        }

        private Node moveRight(Node n, int k) {
            if (k > n.text.length()) {
                n.cursor = n.text.length();
                if (n.next == null) {
                    return n;
                } else {
                    return moveRight(n.next, k - n.text.length());
                }
            } else {
                n.cursor = k;
                return n;
            }
        }


        class Node {
            String text;
            int cursor;
            Node pre;
            Node next;

            public Node(String text, int cursor) {
                this.text = text;
                this.cursor = cursor;
            }

            public void setPre(Node pre) {
                pre.next = this;
                this.pre = pre;
            }

            public void setNext(Node next) {
                next.pre = this;
                this.next = next;
            }
        }

    }

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
//leetcode submit region end(Prohibit modification and deletion)

}