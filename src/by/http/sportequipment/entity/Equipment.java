package by.http.sportequipment.entity;

public /* abstract */ class Equipment {

	private String title;

	public Equipment() {
		super();
	}

	public Equipment(String title) {
		super();
		this.title = title;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Equipment title: " + title;
	}

}
