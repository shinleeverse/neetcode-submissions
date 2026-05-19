class DSU(n : Int){
    private val parent = IntArray(n){it}
    private val rank = IntArray(n){1}

    fun find(node: Int) : Int{
        var cur = node
        while(cur != parent[cur]){
            parent[cur] = parent[parent[cur]]
            cur = parent[cur] 
        }
        return cur
    }

    fun union(n1: Int, n2: Int) : Boolean {
        val pn1 = find(n1)
        val pn2 = find(n2)

        if(pn1 == pn2){
            return false
        }

        if(rank[pn2] > rank[pn1]){
            parent[pn1] = pn2
        } else {
            parent[pn2] = pn1
            rank[pn1] += rank[pn2]
        }

        return true
    }
}

class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val dsu = DSU(edges.size + 1)
        for(edge in edges){
            val (src, des) = edge
            if(dsu.find(src) == dsu.find(des)){
                return edge
            }
            dsu.union(src, des)
        }
        return intArrayOf()
    }
}
