package com.example.chitchat;

// ChatActivity.java
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView chatRecyclerView;
    private ChatAdapter chatAdapter;
    private List<MessageModel> messageList;
    private EditText inputEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatRecyclerView = findViewById(R.id.chatRecyclerView);
        inputEditText = findViewById(R.id.inputEditText);
        sendButton = findViewById(R.id.sendButton);

        messageList = new ArrayList<>();
        chatAdapter = new ChatAdapter(messageList);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatRecyclerView.setAdapter(chatAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMessage = inputEditText.getText().toString().trim();
                if (!userMessage.isEmpty()) {
                    // Add user message to the list
                    messageList.add(new MessageModel(MessageModel.USER_MESSAGE, userMessage));
                    chatAdapter.notifyItemInserted(messageList.size() - 1);

                    // Clear the input field
                    inputEditText.setText("");

                    // Simulate bot's response after a short delay (you can replace this with your own bot logic)
                    simulateBotResponse(userMessage);
                }
            }
        });
    }

    private void simulateBotResponse(String userMessage) {
        // Simulate the bot's response after a short delay (for demonstration purposes)
        // Replace this with your actual chatbot logic and API calls
        String botResponse = "Hi! I'm a simple chatbot. You said: \"" + userMessage + "\"";
        messageList.add(new MessageModel(MessageModel.BOT_MESSAGE, botResponse));
        chatAdapter.notifyItemInserted(messageList.size() - 1);
    }
}
