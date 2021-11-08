package it.example.testFabrick.model.transactions;

import lombok.Data;

import java.util.List;

@Data
public class Transactions{
	private List<ListItem> list;

	/*public List<ListItem> getList(){
		return list;
	}*/

	@Override
	public String toString() {
		return "{" +
				"list=" + list +
				'}';
	}
}