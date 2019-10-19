package com.example.amgiwork

object EmployeeData {

    private val employeeNames = arrayOf(
        "RINI",
        "WARIH",
        "HENY",
        "NODY",
        "ZOLA",
        "KENDY",
        "DIDIE",
        "DITO",
        "FIKRY",
        "IKA"
    )

    private val employeeEligibilities = arrayOf(
        Consts.ELIGIBILITY_ELIGIBLE_ID,
        Consts.ELIGIBILITY_ELIGIBLE_ID,
        Consts.ELIGIBILITY_ELIGIBLE_ID,
        Consts.ELIGIBILITY_SEMI_ID,
        Consts.ELIGIBILITY_SEMI_ID,
        Consts.ELIGIBILITY_SEMI_ID,
        Consts.ELIGIBILITY_SEMI_ID,
        Consts.ELIGIBILITY_NON_ID,
        Consts.ELIGIBILITY_NON_ID,
        Consts.ELIGIBILITY_NON_ID
    )

    private val employeeImages = intArrayOf(
        R.drawable.eligible,
        R.drawable.eligible,
        R.drawable.eligible,
        R.drawable.semi_eligible,
        R.drawable.semi_eligible,
        R.drawable.semi_eligible,
        R.drawable.semi_eligible,
        R.drawable.non_eligible,
        R.drawable.non_eligible,
        R.drawable.non_eligible
    )

    val listData: ArrayList<Employee>
        get() {
            val list = arrayListOf<Employee>()
            for (position in employeeNames.indices) {
                val hero = Employee()
                hero.name = employeeNames[position]
                hero.eligibility = employeeEligibilities[position]
                hero.photo = employeeImages[position]
                list.add(hero)
            }
            return list
        }
}