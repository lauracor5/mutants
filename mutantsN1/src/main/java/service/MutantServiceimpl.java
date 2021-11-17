package service;

import java.util.ArrayList;

public class MutantServiceimpl implements MutantService {
    @Override
    public boolean isMutant(String[] dna) {
        int sequencesFound;
        sequencesFound = validateSequenceByRows(dna);
        if (sequencesFound > 1) {
            return true;
        }
        sequencesFound += validateSequenceByRows(readColumnsTable(passArraytoTable(dna)));
        if (sequencesFound > 1) {
            return true;
        }
        sequencesFound += validateSequenceByRows(readObliqueTableFirstHalf(passArraytoTable(dna)));
        if (sequencesFound > 1) {
            return true;
        }

        sequencesFound += validateSequenceByRows(readObliqueTableSecondHalf(passArraytoTable(dna)));
        return sequencesFound > 1;
    }

    private int validateSequenceByRows(String[] dna) {
        int sequencesFound = 0;
        String sequenceByRow;
        for (String dnaRow : dna) {
            sequenceByRow = dnaRow;
            if (sequenceByRow.contains("AAAA")
                    || sequenceByRow.contains("TTTT")
                    || sequenceByRow.contains("CCCC")
                    || sequenceByRow.contains("GGGG")) {
                sequencesFound++;
            }
        }
        return sequencesFound;
    }

    private String[][] passArraytoTable(String[] dna) {
        String[][] table = new String[dna.length][dna.length];
        String dnaRow;
        String[] dnaCharacterRow;
        for (int rows = 0; rows < dna.length; rows++) {
            dnaRow = dna[rows];
            dnaCharacterRow = dnaRow.split("");
            for (int columns = 0; columns < dna.length; columns++) {
                table[rows][columns] = dnaCharacterRow[columns];
            }
        }
        return table;
    }

    private String[] readColumnsTable(String[][] table) {
        String[] columnsTable = new String[table.length];
        String characterColumn;
        for (int rows = 0; rows < table.length; rows++) {
            characterColumn = "";
            for (int columns = 0; columns < table.length; columns++) {
                characterColumn = characterColumn.concat(table[columns][rows]);
            }
            columnsTable[rows] = characterColumn;
        }
        return columnsTable;
    }

    private String[] readObliqueTableFirstHalf(String[][] table) {
        ArrayList<String> listRows = new ArrayList();
        String[] rowTable = new String[listRows.size()];
        String characterOblique;
        for (int indice = table.length; indice > 0; indice--) {
            characterOblique = "";
            for (int y = Math.min(0, indice), x = Math.max(0, indice); x < table.length && y < table.length; x++, y++) {
                characterOblique = characterOblique.concat(table[y][x]);
            }
            if (!(characterOblique == null || "".equals(characterOblique))) {
                listRows.add(characterOblique);
            }

        }
        for (int indice = 0; indice < table.length; indice++) {
            characterOblique = "";
            for (int x = Math.max(0, indice), y = Math.min(0, indice); x < table.length && y < table.length; x++, y++) {
                characterOblique = characterOblique.concat(table[x][y]);
            }
            if (!(characterOblique == null || "".equals(characterOblique))) {
                listRows.add(characterOblique);
            }

        }
        return listRows.toArray(rowTable);
    }

    private String[] readObliqueTableSecondHalf(String[][] table) {
        ArrayList<String> listRows = new ArrayList();
        String rowTable[] = new String[listRows.size()];
        String characterOblique;

        for (int rows = 0; rows < table.length; rows++) {
            characterOblique = "";
            for (int columns = rows; columns > -1; columns--) {
                characterOblique = characterOblique.concat(table[columns][rows - columns]);
            }
            if (!(characterOblique == null || "".equals(characterOblique))) {
                listRows.add(characterOblique);
            }
        }
        for (int rows = 1; rows < table.length; rows++) {
            characterOblique = "";
            for (int columns = table.length - 1; columns >= rows; columns--) {
                characterOblique = characterOblique.concat(table[columns][rows + table.length - 1 - columns]);
            }
            if (!(characterOblique == null || "".equals(characterOblique))) {
                listRows.add(characterOblique);
            }
        }
        return listRows.toArray(rowTable);
    }

}
