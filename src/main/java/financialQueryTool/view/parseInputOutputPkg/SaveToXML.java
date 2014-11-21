package main.java.financialQueryTool.view.parseInputOutputPkg;

import java.io.File;
import java.nio.file.Path;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.controlsfx.dialog.Dialogs;

import main.java.financialQueryTool.model.stockPkg.StockListWrapper;

public class SaveToXML {

	public void saveStockListToFile(Path path, StockListWrapper stockList) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(StockListWrapper.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(stockList, path.toFile());
					
		} catch (JAXBException e) {
/*			Dialogs.create()
			.title("Error During XML saving.")
			.masthead("Could not save Stock List to File:\n" + path.toAbsolutePath())
			.showException(e);*/
			e.printStackTrace();
		}
	}
}
