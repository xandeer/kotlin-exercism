class BankAccount() {
  private var isOpen = true

  var balance: Long = 0L
  @Synchronized get() {
    check(isOpen)
    return field
  }
  private set

  @Synchronized fun adjustBalance(amount: Long){
    check(isOpen)
    balance += amount
  }

  @Synchronized fun close() {
    isOpen = false
  }
}
