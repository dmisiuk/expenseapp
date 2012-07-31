package by.minsler.helper;

import javax.servlet.http.HttpServletRequest;

public interface ReceiverCommand {

	void execute(HttpServletRequest request);

}
