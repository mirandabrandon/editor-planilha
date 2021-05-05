package com.tunts.desafio.desafiotunts.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EditaExcel {

	private static final String fileName = "C:\\Users\\Brandon\\Documents\\Desafio Tunts\\Cópia de Engenharia de Software - Desafio.xlsx";

	public static void main(String[] args) throws IOException {

		try {
			FileInputStream file = new FileInputStream(new File(EditaExcel.fileName));

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheetAlunos = workbook.getSheetAt(0);

			Row aulas = sheetAlunos.getRow(2);
		//	Double totalDeAulas = aulas.getCell(0).getNumericCellValue();

			for (int i = 4; i < sheetAlunos.getPhysicalNumberOfRows(); i++) {

				Row row = sheetAlunos.getRow(i);
				Cell cellFaltas = row.getCell(2);
				Cell cellNota1 = row.getCell(3);
				Cell cellNota2 = row.getCell(4);
				Cell cellNota3 = row.getCell(5);
				Cell cellSituacao = row.getCell(6);
				Cell cellNotaAprovacaoFinal = row.getCell(7);

				Double media = (cellNota1.getNumericCellValue() + cellNota2.getNumericCellValue()
						+ cellNota3.getNumericCellValue()) / 3;

				if (cellFaltas.getNumericCellValue() / 60 > 0.25) {
					cellSituacao.setCellValue("Reprovado por Falta");

				} else if (cellFaltas.getNumericCellValue() / 60 <= 0.25 && media < 5) {
					cellSituacao.setCellValue("Reprovado por Nota");
					cellNotaAprovacaoFinal.setCellValue("0");
				} else if (cellFaltas.getNumericCellValue() / 60 <= 0.25 && media >= 5 && media < 7) {
					cellSituacao.setCellValue("Exame Final");
					cellNotaAprovacaoFinal.setCellValue(10 - media);
				} else if (cellFaltas.getNumericCellValue() / 60 <= 0.25 && media > 7) {
					cellSituacao.setCellValue("Aprovado");
					cellNotaAprovacaoFinal.setCellValue("0");
				}

			}
			file.close();

			FileOutputStream outFile = new FileOutputStream(new File(EditaExcel.fileName));
			workbook.write(outFile);
			outFile.close();
			System.out.println("Arquivo Excel editado com sucesso!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo Excel não encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
		}

	}

}