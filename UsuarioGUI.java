import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioGUI extends JFrame {
    private Usuario usuario;
    private JLabel lblDinheiro;

    public UsuarioGUI(Usuario usuario) {
        this.usuario = usuario;
        setTitle("Perfil do Usuário");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 200);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome: " + usuario.getUsername());
        JLabel lblIdade = new JLabel("Idade: " + usuario.getIdade());
        JLabel lblEmail = new JLabel("Email: " + usuario.getEmail());
        lblDinheiro = new JLabel("Carteira: R$" + String.format("%.2f", usuario.getCarteira()));

        JTextField txtDinheiro = new JTextField(10);
        JButton btnAdicionarDinheiro = new JButton("Adicionar Dinheiro");
        btnAdicionarDinheiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    float dinheiroAdicional = Float.parseFloat(txtDinheiro.getText());
                    usuario.addDinheiroCarteira(dinheiroAdicional);
                    updateUsuarioContent();
                    txtDinheiro.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(UsuarioGUI.this, "Digite um valor válido.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(lblNome);
        panel.add(lblIdade);
        panel.add(lblEmail);
        panel.add(lblDinheiro);
        panel.add(txtDinheiro);
        panel.add(btnAdicionarDinheiro);

        add(panel);
    }

    public void updateUsuarioContent() {
        if (lblDinheiro != null)
            lblDinheiro.setText("Carteira: R$" + String.format("%.2f", usuario.getCarteira()));
    }
}