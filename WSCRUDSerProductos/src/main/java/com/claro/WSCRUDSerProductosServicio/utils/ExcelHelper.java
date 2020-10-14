package com.claro.WSCRUDSerProductosServicio.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.claro.WSCRUDSerProductosServicio.dto.Constantes;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	private Workbook workbook;
	private Iterator<Row> rows;
	private Sheet sheet;
	private DataFormatter formatter;

	public ExcelHelper() {
		formatter = new DataFormatter();
	}

	/* verifica si es un archivo excel */
	public static boolean hasExcelFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	/*
	 * Se abre el archivo excel, en la hoja indicada y se omiten las filas de la
	 * cabecera
	 */
	public void loadFileExcel(InputStream is, String nameSheet, int skipHeaders) {
		try {
			this.workbook = new XSSFWorkbook(is);
			this.sheet = workbook.getSheet(nameSheet);
			this.rows = sheet.iterator();
			int rowNumber = 0;

			// skip header
			while (this.rows.hasNext() && rowNumber < skipHeaders) {
				rows.next();
				rowNumber++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* retorna las filas del archivo cargado */
	public Iterator<Row> getRows() {
		return rows;
	}

	/* Cierra el archivo */
	public void closeFileExcel() {
		try {
			this.workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ByteArrayInputStream getFile() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			this.workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	}

	/* se obtiene en una cadena de texto la informacion de la fila, separa por ; */
	public String obtenerfilaArchivo(Row currentRow, Integer limite) {
		String result = "";
		Iterator<Cell> cellsInRow = currentRow.iterator();
		int i = 0;
		while (cellsInRow.hasNext() && !Objects.equals(i, limite)) {
			Cell currentCell = cellsInRow.next();
			result += ((result.equals("")) ? "" : Constantes.SEPARADOR_TEXTO) + formatter.formatCellValue(currentCell);
			i++;
		}
		return result;
	}

	public void escribirCelda(Row currentRow, int celda, String texto) {
		currentRow.createCell(celda).setCellValue(texto);
	}
	public String obtenerValorCelda(Row row, int numCol) {
		return row.getCell(numCol).getStringCellValue();
	}

}
