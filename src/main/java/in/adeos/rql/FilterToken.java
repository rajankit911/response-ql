package in.adeos.rql;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * FilterToken forms the basis of RQL Tree Model.
 * <p>
 * As a general design rule, most accessors ("getters") and mutators ("setters")
 * are included in this base class.
 *  
 * @author Ankit Raj
 * @since 1.0.0
 */
public class FilterToken {
	private String name;
	private boolean exclude;
	private Set<String> properties = new HashSet<>();
	private Map<String, FilterToken> children = new HashMap<>();
	
	FilterToken(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isExclude() {
		return exclude;
	}

	public void setExclude(boolean exclude) {
		this.exclude = exclude;
	}

	public Set<String> getProperties() {
		return properties;
	}

	public void setProperties(Set<String> properties) {
		this.properties = properties;
	}

	public Map<String, FilterToken> getChildren() {
		return children;
	}

	public void setChildren(Map<String, FilterToken> children) {
		this.children = children;
	}
}
