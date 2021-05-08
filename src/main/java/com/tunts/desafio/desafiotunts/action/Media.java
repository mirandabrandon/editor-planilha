package com.tunts.desafio.desafiotunts.action;

import org.apache.poi.ss.usermodel.Cell;

public class Media {

	private Double media;

	public double mediaCalculada(Cell cellNota1, Cell cellNota2, Cell cellNota3) {
		media = (cellNota1.getNumericCellValue() + cellNota2.getNumericCellValue() + cellNota3.getNumericCellValue())
				/ 30;
		return media;
	}
}


