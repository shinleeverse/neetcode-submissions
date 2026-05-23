/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *                1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num: Int): Int
 */

class Solution : GuessGame() {
    fun guessNumber(n: Int): Int {
        var left = 1
        var right = n
        while(left <= right){
            val mid = left + (right - left) / 2
            val result = guess(mid)
        
            when(result){
                0 -> return mid
                -1 -> right = mid - 1
                1 -> left = mid + 1
            }
        }

        return -1
    }
}
