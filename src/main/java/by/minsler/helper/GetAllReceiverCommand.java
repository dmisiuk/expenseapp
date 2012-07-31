package by.minsler.helper;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.minsler.beans.Receiver;
import by.minsler.dao.ExpenseReceiverDAO;
import by.minsler.dao.MysqlExpenseReceiverDAO;

public class GetAllReceiverCommand implements ReceiverCommand {

	private static Logger logger = Logger.getLogger(ReceiverHelper.class);

	public void execute(HttpServletRequest request) {
		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();
		ArrayList<Receiver> list = erdao.getReceivers();
		logger.info("get all receiver");
		request.setAttribute("listreceiver", list);
		logger.info("added list receiver to request");
		return;
	}

}
