This project demonstrate how can you set basic authentication using SpringSecurity.  

Asap we setup spring security libraray in spring proect, Spring by default enables the UI form with userName and password authentication (it creates a temporary username and password)  
which you can find in logs or override it in properties file.  
  
To enable Basic authentication, below given steps should be taken to get it working  
1 - Disable UI form, in SecurityFilter chain bean, update HttpSecurity http objec httpBasic(withDefaults()) so it can use basicAuth  
2 - To get userNamePassword based login, we need to create userEntity, userService and userRpo classes/interface.  
3 - We will return our custom bean in secrutiy config for AuthenticationManager (which will use ProviderManager).  
4 - The providerManager uses DaoAuthenticatoinProvider.  
5 - We will pass our own CustomUserDetailsService class as dependency to DaoAuthenticationProvider (so we can use our own database call for authentiation of userName & Password)  
6 - In the same SecurityConfigue class we will return a Bean of type UserDetails servie by creating new object of CustomUserDetailsSerivce (which implements UserDetailsService).  
7 - CustomUserDetailsService has dependency object and and overriden method of signature public UserDetails loadUserByUsername(String username)  
8 - Since this method expects UserDetials, we will update our User entity to extend UserDetails service (polymorphism in action)  
9 - We will also export a Bean from security config with following method  @Beanpublic PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder()}  
10 - The DaoAuthenticationProvider we used in step 4 - 5 will set PasswordEncoder for encoding the password stored in DB (daoAuthenticationProvider.setPasswordEncoder(passwordEncoder))  
11 - There is a Component added in the project just to initialize the admin data (public class AdminUserInitializer) so that we have a user ready for login in DB.  

After above mentioned configurations, our Spring secrutiy should be able to work with BasicUserName and password flow.  

