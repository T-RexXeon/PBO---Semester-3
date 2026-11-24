import java.awt.*;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JPointOfSales extends JFrame {

    private JTable tableProduk;
    private JTable tableKeranjang;
    private DefaultTableModel modelProduk;
    private DefaultTableModel modelKeranjang;

    private JLabel lblSelected;
    private JTextField txtQty;
    private JButton btnAddToCart;

    private JLabel lblTotal;
    private JLabel lblPoints;
    private JButton btnCheckout;
    private JButton btnCetak;
    private JTextArea txtStruk;

    private DecimalFormat rupiahFormat;

    public JPointOfSales() {
        setupCurrencyFormatter();
        initComponents();
        initDataProduk();
        initEvents();
    }

    private void setupCurrencyFormatter() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        rupiahFormat = new DecimalFormat("#,##0.00", symbols);
    }

    private String formatRupiah(double amount) {
        return "Rp" + rupiahFormat.format(amount);
    }

    private void initComponents() {
        setTitle("POIN Off-Sales - Java Swing");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem itemReset = new JMenuItem("Transaksi Baru");
        JMenuItem itemExit = new JMenuItem("Exit");
        itemReset.addActionListener(e -> resetSemua());
        itemExit.addActionListener(e -> System.exit(0));
        menuFile.add(itemReset);
        menuFile.addSeparator();
        menuFile.add(itemExit);

        JMenu menuHelp = new JMenu("Help");
        JMenuItem itemAbout = new JMenuItem("About");
        itemAbout.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "Aplikasi Point of Sales (POS) Sederhana\nJava Swing",
                "About",
                JOptionPane.INFORMATION_MESSAGE));
        menuHelp.add(itemAbout);

        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);

        JPanel panelProduk = new JPanel(new BorderLayout(5, 5));
        panelProduk.setBorder(BorderFactory.createTitledBorder("Produk"));

        String[] kolomProduk = {"ID", "Nama Produk", "Harga (Rp)"};
        modelProduk = new DefaultTableModel(kolomProduk, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableProduk = new JTable(modelProduk);
        tableProduk.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panelProduk.add(new JScrollPane(tableProduk), BorderLayout.CENTER);

        JPanel panelProdukBottom = new JPanel();
        panelProdukBottom.setLayout(new BoxLayout(panelProdukBottom, BoxLayout.Y_AXIS));
        panelProdukBottom.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        lblSelected = new JLabel("Pilih produk dari tabel di kiri");
        lblSelected.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel panelQty = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panelQty.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelQty.add(new JLabel("Qty:"));
        txtQty = new JTextField("1", 4);
        panelQty.add(txtQty);
        btnAddToCart = new JButton("Add to Cart");
        panelQty.add(btnAddToCart);

        panelProdukBottom.add(lblSelected);
        panelProdukBottom.add(panelQty);
        panelProduk.add(panelProdukBottom, BorderLayout.SOUTH);

        JPanel panelKeranjang = new JPanel(new BorderLayout(5, 5));
        panelKeranjang.setBorder(BorderFactory.createTitledBorder("Keranjang"));

        String[] kolomKeranjang = {"ID", "Nama Produk", "Qty", "Harga", "Subtotal"};
        modelKeranjang = new DefaultTableModel(kolomKeranjang, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableKeranjang = new JTable(modelKeranjang);
        JScrollPane scrollKeranjang = new JScrollPane(tableKeranjang);
        scrollKeranjang.setPreferredSize(new Dimension(420, 180));
        panelKeranjang.add(scrollKeranjang, BorderLayout.NORTH);

        JPanel panelCheckoutArea = new JPanel(new BorderLayout(5, 5));
        panelCheckoutArea.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JPanel panelSummary = new JPanel();
        panelSummary.setLayout(new BoxLayout(panelSummary, BoxLayout.Y_AXIS));

        lblTotal = new JLabel("Total: Rp0,00");
        lblTotal.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblTotal.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblPoints = new JLabel("Points: 0");
        lblPoints.setAlignmentX(Component.LEFT_ALIGNMENT);

        btnCheckout = new JButton("Checkout");
        btnCheckout.setAlignmentX(Component.LEFT_ALIGNMENT);

        btnCetak = new JButton("Cetak");
        btnCetak.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblStrukTitle = new JLabel("Struk:");
        lblStrukTitle.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblStrukTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelSummary.add(lblTotal);
        panelSummary.add(Box.createVerticalStrut(4));
        panelSummary.add(lblPoints);
        panelSummary.add(Box.createVerticalStrut(8));
        panelSummary.add(btnCheckout);
        panelSummary.add(Box.createVerticalStrut(4));
        panelSummary.add(btnCetak);
        panelSummary.add(Box.createVerticalStrut(8));
        panelSummary.add(lblStrukTitle);

        txtStruk = new JTextArea();
        txtStruk.setEditable(false);
        txtStruk.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollStruk = new JScrollPane(txtStruk);

        panelCheckoutArea.add(panelSummary, BorderLayout.NORTH);
        panelCheckoutArea.add(scrollStruk, BorderLayout.CENTER);

        panelKeranjang.add(panelCheckoutArea, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelProduk, panelKeranjang);
        splitPane.setDividerLocation(420);
        add(splitPane);
    }

    private void initDataProduk() {
        Object[][] data = {
            {"P001", "Air Mineral 600ml", 3000},
            {"P002", "Kopi Sachet", 5000},
            {"P003", "Roti isi", 8000},
            {"P004", "Snack Keripik", 6000},
            {"P005", "Minuman Botol", 12000}
        };
        for (Object[] row : data) {
            modelProduk.addRow(row);
        }
    }

    private void initEvents() {
        tableProduk.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tableProduk.getSelectedRow() != -1) {
                int row = tableProduk.getSelectedRow();
                String id = modelProduk.getValueAt(row, 0).toString();
                String nama = modelProduk.getValueAt(row, 1).toString();
                double harga = Double.parseDouble(modelProduk.getValueAt(row, 2).toString());

                lblSelected.setText("Dipilih: " + id + " - " + nama + " (" + formatRupiah(harga) + ")");
            }
        });

        btnAddToCart.addActionListener(e -> tambahKeKeranjang());

        btnCheckout.addActionListener(e -> prosesCheckout());

        btnCetak.addActionListener(e -> cetakStruk());
    }

    private void tambahKeKeranjang() {
        int selectedRow = tableProduk.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih produk terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int qty;
        try {
            qty = Integer.parseInt(txtQty.getText().trim());
            if (qty <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Qty harus berupa angka bulat positif!", "Input Tidak Valid", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String id = modelProduk.getValueAt(selectedRow, 0).toString();
        String nama = modelProduk.getValueAt(selectedRow, 1).toString();
        int harga = Integer.parseInt(modelProduk.getValueAt(selectedRow, 2).toString());

        boolean found = false;
        for (int i = 0; i < modelKeranjang.getRowCount(); i++) {
            if (modelKeranjang.getValueAt(i, 0).toString().equals(id)) {
                int existingQty = Integer.parseInt(modelKeranjang.getValueAt(i, 2).toString());
                int newQty = existingQty + qty;
                int newSubtotal = newQty * harga;
                modelKeranjang.setValueAt(newQty, i, 2);
                modelKeranjang.setValueAt(newSubtotal, i, 4);
                found = true;
                break;
            }
        }

        if (!found) {
            int subtotal = qty * harga;
            modelKeranjang.addRow(new Object[]{id, nama, qty, harga, subtotal});
        }

        txtQty.setText("1");
        hitungTotalDanPoints();
    }

    private void hitungTotalDanPoints() {
        double total = 0;
        for (int i = 0; i < modelKeranjang.getRowCount(); i++) {
            total += Double.parseDouble(modelKeranjang.getValueAt(i, 4).toString());
        }
        int points = (int) (total / 1000); // 1 point per Rp 1000
        lblTotal.setText("Total: " + formatRupiah(total));
        lblPoints.setText("Points: " + points);
    }

    private void prosesCheckout() {
        if (modelKeranjang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Keranjang masih kosong!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("===== POIN OFF-SALES =====\n");
        sb.append("Toko: Demo Toko\n");
        sb.append("================================\n");
        sb.append(String.format("%-4s %-15s %-4s %s\n", "ID", "Nama", "Qty", "Subtotal"));

        double total = 0;
        for (int i = 0; i < modelKeranjang.getRowCount(); i++) {
            String id = modelKeranjang.getValueAt(i, 0).toString();
            String nama = modelKeranjang.getValueAt(i, 1).toString();
            int qty = Integer.parseInt(modelKeranjang.getValueAt(i, 2).toString());
            double subtotal = Double.parseDouble(modelKeranjang.getValueAt(i, 4).toString());
            total += subtotal;

            sb.append(String.format("%-4s %-15s %-4d %s\n", id, nama, qty, formatRupiah(subtotal)));
        }

        int points = (int) (total / 1000);
        sb.append("================================\n");
        sb.append(String.format("TOTAL:          %s\n", formatRupiah(total)));
        sb.append(String.format("POINTS DIDAPAT: %d (1 point per Rp 1000)\n", points));
        sb.append("================================\n");
        sb.append("Terima kasih! Silakan kunjungi kembali.");

        txtStruk.setText(sb.toString());

        modelKeranjang.setRowCount(0);
        lblTotal.setText("Total: Rp0,00");
        lblPoints.setText("Points: 0");
    }

    private void cetakStruk() {
        if (txtStruk.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Belum ada struk untuk dicetak. Lakukan Checkout terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            boolean complete = txtStruk.print();
            if (complete) {
                JOptionPane.showMessageDialog(this, "Struk berhasil dikirim ke printer.", "Cetak", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mencetak struk: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetSemua() {
        modelKeranjang.setRowCount(0);
        tableProduk.clearSelection();
        lblSelected.setText("Pilih produk dari tabel di kiri");
        txtQty.setText("1");
        lblTotal.setText("Total: Rp0,00");
        lblPoints.setText("Points: 0");
        txtStruk.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JPointOfSales().setVisible(true);
        });
    }
}