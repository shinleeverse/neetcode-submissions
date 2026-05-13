/**

([{}])
^^^

}])

stack = [(,[,{]

if not in bracketMap:
    }
    removeLast -> get bracketMap[removelast] -> check

**/

class Solution {
    fun isValid(s: String): Boolean {
        val openBrackets = hashMapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']'
        )

        val stack = mutableListOf<Char>()

        for (bracket in s){
            // Open Bracket
            if (openBrackets.contains(bracket)){
                stack.add(bracket)
                continue
            } 

            if (stack.size == 0){
                return false
            }

            // Close Bracket
            val lastBracket = stack.removeLast()
            if (openBrackets[lastBracket] != bracket){
                return false
            }
        }

        return stack.size == 0

    }
}
