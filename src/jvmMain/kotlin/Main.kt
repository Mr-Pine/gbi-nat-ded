
fun main(args: Array<String>) {
    val argFormula =
         "(P -> 0) -> -P"
        //"P | -P"
        // "P | (P->0)"
        // "P -> -P -> 0"// args[0]
    val goal = formulaGrammar.parseToEnd(argFormula)
    val pt = findProof(goal, listOf())
    pt?.printTree()
}

private fun ProofTree.printTree(indent: Int = 0) {
    print("   ".repeat(indent))
    val ass = usedAssumptions()
    println(ass.toString() + " |- " + formula.toString() + " by " + appliedRule?.name)
    children.forEach {
        it.printTree(indent + 1)
    }
}
