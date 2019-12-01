package ui.model;

import CompatibilityChecker.Parts.Part;

import javax.swing.*;
import javax.swing.event.ListDataListener;

public class PartComboBoxModel implements ComboBoxModel {

    private Part[] parts;
    private Object selected;


    public PartComboBoxModel(Part[] parts) {
        this.parts = parts;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

    @Override
    public int getSize() {
        return parts.length;
    }

    @Override
    public Object getElementAt(int index) {
        return parts[index];
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
