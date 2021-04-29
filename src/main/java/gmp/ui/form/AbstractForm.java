package gmp.ui.form;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class AbstractForm<T> extends JPanel{

	public abstract void setItem(T item);
	public abstract T getItem();
	public abstract void validCheck();
	public abstract void clearTf();
	
}
