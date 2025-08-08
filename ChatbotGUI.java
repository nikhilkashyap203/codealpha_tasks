
import AIChatBot.Chatbot;
import java.awt.*;
import javax.swing.*;

public class ChatbotGUI {
    private final Chatbot bot = new Chatbot();

    public void Launch() {
        JFrame frame = new JFrame("AI Chatbot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        JTextField userInput = new JTextField();
        JButton sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(sendButton, BorderLayout.EAST);
        inputPanel.add(userInput, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        sendButton.addActionListener(_ -> {
            String input = userInput.getText();
            if (!input.isEmpty()) {
                chatArea.append("You: " + input + "\n");
                String response = bot.GetResponse(input);
                chatArea.append("Bot: " + response + "\n\n");
                userInput.setText("");
            }
        });

        userInput.addActionListener(_ -> sendButton.doClick());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChatbotGUI().Launch());
    }
}