class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val closeToOpen = hashMapOf(
            ')' to '(',
            ']' to '[',
            '}' to '{',
        )

        for (bracket in s){
            // Open Bracket
            if (bracket !in closeToOpen){
                stack.addLast(bracket)
                continue
            }

            // Close Bracket
            if (stack.isNotEmpty() && stack.last() == closeToOpen[bracket]){
                stack.removeLast()
            } else {
                return false
            }
        }

        return stack.isEmpty()
    }
}
