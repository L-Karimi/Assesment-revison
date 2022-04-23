fun main(){
    var c=CurrentAccount("1036900100","Safe",1000.5)
    c.deposit(2000.5)
    c.withdraw(404.5)
    c.details()

    var s=SavingsAccount("102349859","Sean",2000.2,1)
    s.deposit(2000.5)
    s.withdraw(404.5)
    println(s.withdrawal)
    s.details()

    var a= Product("Oranges",30.3,400.5,"groceries")
    item(a)
    var b= Product("Bathing soap",40.2,50.5,"hygiene")
    item(b)
    var d= Product("Lucy",12.5,100.0,"other")
    item(d)

    fruit("Banana")
}




//.Create a classCurrentAccount with th}e following attributes:account
//number, account name, balance. It has the following functions:
//a.deposit(amount: Double) - Increments the balance bythe
//amount deposited
//b.withdraw(amount: Double) - Decrements the balanceby the
//amount withdrawn
//c.details() - Prints out the account number and balanceand
//name in this format: “Account number x with balance y is
//operated by z”(5points)

open class CurrentAccount(var AccountNumber:String,var AccountName:String,var balance:Double){
    fun deposit(amount:Double){
        balance+=amount
        println(balance)
    }
    open fun withdraw(amount:Double){
        balance-=amount
        println(balance)

    }
    fun details(){
        println("Account number $AccountNumber with $balance is operated by $AccountName ")



    }

}
//Create another classSavingsAccount. It has the samefunctions and
//attributes as the current account except for one attribute,
//withdrawals: Int. Withdrawals is a counter variablethat is used to
//keep track of how many withdrawals have been made from the account
//in a year. The only other difference is that the savings account
//withdraw() method first checks if the number of withdrawalsis less
//than 4 for it to allow one to withdraw money from the account. It also
//increments the withdrawals attribute after a successful withdrawal
//(5points

class SavingsAccount(AccountNumber: String,AccountName: String,balance: Double,var withdrawal:Int):CurrentAccount(AccountNumber,AccountName,balance){
    override fun withdraw(amount: Double) {
        if (withdrawal < 4) {
            println(balance)
            withdrawal++
        }
        else{
            println("Not successful!")
        }

    }
}
//.A product is represented by a data class with these attributes: name,
//weight, price, category. Category can either be groceries, hygiene or
//other. Write a function that takes in a product and uses a when
//statement to assign each product to a list based on its category
data class Product(var proDuct:String , var weight:Double, var price:Double, var category:String)
fun item(product: Product){
    var groceriesItems= mutableListOf<Product>()
    var hygieneItems= mutableListOf<Product>()
    var otherItems= mutableListOf<Product>()

    when(product.category){
        "groceries" ->groceriesItems.add(product)
        "hygiene" ->hygieneItems.add(product)
        "other" ->otherItems.add(product)
    }
    println(listOf(product))

}

//Write a function that given a string returns a string composed of only
//the characters in even indices. For example given “banana” it will return
//“bnn”

fun fruit(b:String):String {
    var fruit = ""
    b.forEachIndexed { index, c ->
        if (index % 2 == 0) {
            fruit += c
        }
    }
    println(fruit)
    return fruit
}