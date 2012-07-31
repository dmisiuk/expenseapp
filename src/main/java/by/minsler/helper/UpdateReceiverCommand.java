package by.minsler.helper;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.minsler.beans.Receiver;
import by.minsler.dao.ExpenseReceiverDAO;
import by.minsler.dao.MysqlExpenseReceiverDAO;

public class UpdateReceiverCommand implements ReceiverCommand {

	private static Logger logger = Logger.getLogger(ReceiverHelper.class);

	public void execute(HttpServletRequest request) {

		int result;
		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		if (name == null || name.trim().equals("")) {
			logger.info("receiver parameter not valid");
			request.setAttribute("flash", "receiver parameter not valid");
			logger.info("added flash to request");
		}
		Receiver receiver = new Receiver();
		receiver.setName(name);
		receiver.setNum(id);
		result = erdao.updateReceiver(receiver.getNum(), receiver);
		if (result == 1) {
			request.setAttribute("flash", "Success");
			logger.info("added flash to request");
		}
		logger.info("add receiver");

		GetAllReceiverCommand getAllCommand = new GetAllReceiverCommand();
		getAllCommand.execute(request);
	}

}