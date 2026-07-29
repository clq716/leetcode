# leetcode
Leet code practice code
Personal Practice Code

## Leetcode Editor Plugin Configuration

### File Path
`/home/${username}/Workspace/GitHub/leetcode/src/main/java/hot100`

### Code File Name
`$_$!velocityTool.leftPadZeros($!{question.frontendQuestionId},4)_$!velocityTool.camelCaseName(${question.titleSlug})`

### Code Template
```java
package hot100.leetcode.editor.${question.endpointType};

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * $!{question.frontendQuestionId}: ${question.title}
 * RedmiBook, Fedora
 * $!velocityTool.date()
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_$!velocityTool.leftPadZeros($!{question.frontendQuestionId},4)_$!velocityTool.camelCaseName(${question.titleSlug}) {

${question.codeWithIndent(4)}
    
    static void main() {
        Solution solution = new $_$!velocityTool.leftPadZeros($!{question.frontendQuestionId},4)_$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        // put your test code here
        
    }
}
```