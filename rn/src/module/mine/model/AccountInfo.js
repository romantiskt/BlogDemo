export default class AccountInfo {
    constructor(json) {
        this.account_info = json.account_info
        this.financial_info = json.financial_info
        this.bank_cards=json.bank_cards
        this.cash_balance=json.cash_balance
        this.coupon_amount=json.coupon_amount
        this.oil_card=json.oil_card
        this.set_password=json.set_password
    }


}