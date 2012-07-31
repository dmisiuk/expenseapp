package by.minsler.helper;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.minsler.beans.Receiver;
import by.minsler.dao.ExpenseReceiverDAO;
import by.minsler.dao.MysqlExpenseReceiverDAO;

public class EditReceiverCommand implements ReceiverCommand {

	private static Logger logger = Logger.getLogger(ReceiverHelper.class);

	public void execute(HttpServletRequest request) {
		Receiver receiver = null;
		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();
		int id = Integer.parseInt(request.getParameter("id"));
		receiver = erdao.getReceiver(id);
		request.setAttribute("receiver", ReceiverHelper.get(id));
		logger.info("get receiver");

		GetAllReceiverCommand getAllCommand = new GetAllReceiverCommand();
		getAllCommand.execute(request);
	}

}
