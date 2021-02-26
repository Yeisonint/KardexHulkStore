package com.yesh.kardex.dto;

import javax.validation.constraints.*;

public class ClientDTO {
	
	@NotNull
    @NotEmpty
	private long id;
	@NotNull
    @NotEmpty
	private String name;
	@NotNull
    @NotEmpty
	private String username;
	@NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;
	@NotNull
    @NotEmpty
	private String email;

	public ClientDTO() {
	}

	public ClientDTO(@NotNull @NotEmpty long id, @NotNull @NotEmpty String name, @NotNull @NotEmpty String username, @NotNull @NotEmpty String password,
			String matchingPassword, @NotNull @NotEmpty String email) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.email = email.toLowerCase();
	}
	
	public ClientDTO(@NotNull @NotEmpty long id, @NotNull @NotEmpty String name, @NotNull @NotEmpty String username, @NotNull @NotEmpty String password,
			@NotNull @NotEmpty String email) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.matchingPassword = password;
		this.email = email.toLowerCase();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

}
