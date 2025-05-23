import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private MyUserDetailsService UserDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    final String header=request.getHeader("Authorization");
    if(header ==null|| !header.startsWith("Bearer ")){
        filterChain.doFilter(request,response);
        return;
    }
    
}
