class FeeService {		
    public String payFee(String regNo, String amountText) {
        if (regNo == null || regNo.trim().isEmpty()) {
            return "Invalid Register Number";
        }
        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            return "Invalid Amount";
        }
        if (amount <= 0) {
            return "Amount must be greater than zero";
        }
        // Database operation can be performed here.
        return "Payment Successful";
    }
}
