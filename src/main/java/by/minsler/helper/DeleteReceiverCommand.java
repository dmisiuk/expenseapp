package by.minsler.helper;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.minsler.dao.ExpenseReceiverDAO;
import by.minsler.dao.MysqlExpenseReceiverDAO;

public class DeleteReceiverCommand implements ReceiverCommand {

	private static Logger logger = Logger
			.getLogger(DeleteReceiverCommand.class);

	public void execute(HttpServletRequest request) {
		int result;
		int id = Integer.parseInt(request.getParameter("id"));
		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();
		result = erdao.delReceiver(id);
		request.setAttribute("flash", "Deleted " + result + " receiver(s)");
		logger.info("add flash message to request");

		GetAllReceiverCommand getAllCommand = new GetAllReceiverCommand();
		getAllCommand.execute(request);
	}
}
