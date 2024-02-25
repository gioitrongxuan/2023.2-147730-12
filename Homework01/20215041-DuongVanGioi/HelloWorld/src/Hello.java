
public class Hello {
	public static void main(String[] args) {
		 MessageModel messageModel = new MessageModel();
		 MessageView messageView = new MessageView();
		 MessageController messageController = new MessageController(messageModel, messageView);
		 messageView.setVisible(true);
		
	}
}
