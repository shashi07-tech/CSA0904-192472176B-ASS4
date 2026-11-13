import java.awt.*;
import java.awt.event.*;
public class FeeWindow extends Frame {
    TextField regNo = new TextField(15);
    TextField amount = new TextField(15);
    Button pay = new Button("Pay");
    Button clear = new Button("Clear");
    Button receipt = new Button("Receipt");
    Label result = new Label(" ");
    FeeService service = new FeeService();
    public FeeWindow() {
        setLayout(new FlowLayout());
        add(new Label("Register No:"));
        add(regNo);
        add(new Label("Amount:"));
        add(amount);
        add(pay);
        add(clear);
        add(receipt);
        add(result);
        pay.addActionListener(e -> {
            String message =
                service.payFee(regNo.getText(), amount.getText());
            result.setText(message);
        });
        clear.addActionListener(e -> {
            regNo.setText("");
            amount.setText("");
            result.setText(" ");
        });
        receipt.addActionListener(e ->
            result.setText("Receipt generated"));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setSize(450, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FeeWindow();
    }
}
