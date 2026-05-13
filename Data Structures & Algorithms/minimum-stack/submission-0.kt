/**
stack = [1,2]
curMin = [1,1]
minStack = 0

stack = []
**/


class MinStack() {

    private val curMin = ArrayDeque<Int>()
    private val stack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        val minValue = if(curMin.isNotEmpty()) Math.min(`val`, curMin.last()) else `val`
        curMin.addLast(minValue)
    }

    fun pop() {
        stack.removeLast()
        curMin.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return curMin.last()
    }
}
