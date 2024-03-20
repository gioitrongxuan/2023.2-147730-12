import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageController {
	private MessageModel messageModel;
	private MessageView messageView;
	
	MessageController(MessageModel messageModel, MessageView messageView){
		this.messageModel = messageModel;
		this.messageView = messageView;
		
		messageView.addHelloListener(new SayHelloListener());
	}
	class SayHelloListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			messageModel.setMessage(messageView.getName());
			messageView.displayHelloMessage(messageModel.getMessage());
		}
	}
}
