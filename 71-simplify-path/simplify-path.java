class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] paths = path.split("/");

        for (String c : paths) {
            if (c.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!c.equals(".") && !c.equals("")) {
                stack.push(c);
            }
        }
        return "/" + String.join("/", stack);
    }
}

//             boolean flag = false;
//             if(!stack.isEmpty() && c == '/' && stack.peek() == '/'){
//                 flag = true;
//             }
//             if(!flag){
//                 stack.push(c);
//             }
//         }
//         if(stack.peek() == '/'){
//             stack.pop();
//         }
//         
//         return sb.toString();
//     }
// }