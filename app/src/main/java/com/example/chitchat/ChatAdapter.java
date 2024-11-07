package com.example.chitchat;


// ChatAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MessageModel> messageList;

    public ChatAdapter(List<MessageModel> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == MessageModel.USER_MESSAGE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_message, parent, false);
            return new UserMessageViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bot_message, parent, false);
            return new BotMessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageModel message = messageList.get(position);
        if (holder instanceof UserMessageViewHolder) {
            ((UserMessageViewHolder) holder).userMessageTextView.setText(message.getContent());
        } else if (holder instanceof BotMessageViewHolder) {
            ((BotMessageViewHolder) holder).botMessageTextView.setText(message.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return messageList.get(position).getType();
    }

    static class UserMessageViewHolder extends RecyclerView.ViewHolder {
        TextView userMessageTextView;

        UserMessageViewHolder(View itemView) {
            super(itemView);
            userMessageTextView = itemView.findViewById(R.id.botMessageTextView);
        }
    }

    static class BotMessageViewHolder extends RecyclerView.ViewHolder {
        TextView botMessageTextView;

        BotMessageViewHolder(View itemView) {
            super(itemView);
            botMessageTextView = itemView.findViewById(R.id.botMessageTextView);
        }
    }
}

