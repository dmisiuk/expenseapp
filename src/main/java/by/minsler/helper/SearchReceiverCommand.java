package by.minsler.helper;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.minsler.beans.Receiver;
import by.minsler.dao.ExpenseReceiverDAO;
import by.minsler.dao.MysqlExpenseReceiverDAO;

public class SearchReceiverCommand implements ReceiverCommand {

	private static Logger logger = Logger.getLogger(ReceiverHelper.class);

	public void execute(HttpServletRequest request) {
		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();
		String name = request.getParameter("name");
		if (name == null || name.trim().equals("")) {
			logger.info("receiver parameter not valid");
			request.setAttribute("flash", "receiver parameter not valid");
			logger.info("added flash to request");
			return;
		}
		ArrayList<Receiver> list = erdao.searchReceivers(name);
		logger.info("get all receiver");
		request.setAttribute("listreceiver", list);
		logger.info("added list receiver to request");
		return;
	}

}