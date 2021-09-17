package org.test.aladdin.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Item{
	
	public String Title = "";
	public String Author = "";
	public String Description = "";
	
}