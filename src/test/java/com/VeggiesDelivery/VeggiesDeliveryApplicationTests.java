package com.VeggiesDelivery;


import com.VeggiesDelivery.controleer.*;
import com.VeggiesDelivery.entity.*;
import com.VeggiesDelivery.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

// Mockito test with Junit
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.VeggiesDelivery.VeggiesDeliveryApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class VeggiesDeliveryApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    public ProductService productService;

    @BeforeEach
    public void setup(){
        ProductController controller = new ProductController();
        controller.setProductService(productService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    // ACTUAL OUTPUT
    Product product = new Product(1,"Potato", 30, 1, "www.google.com");


    // Test Case for Product
    @Test
    public void getProductByIdTest() throws Exception {
        Mockito.when(productService.getProductById(Mockito.anyLong())).thenReturn(product);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/1")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        // EXPECTED OUTPUT
        String expectedProduct = "{ 'id': 1, 'name': 'Potato', 'price': 30, 'quantity': 1," +
                " 'imageUrl': 'www.google.com'}";
        JSONAssert.assertEquals(expectedProduct, result.getResponse().getContentAsString(), false);
    }

    // TEST CASES FOR CART ENTITY

    @Autowired
    private MockMvc mockMvc1;
    @MockBean
    private CartService cartService;

    @BeforeEach
    public void setup1(){
        CartController controller = new CartController();
        controller.setCartService(cartService);
        mockMvc1 =   MockMvcBuilders.standaloneSetup(controller).build();
    }

    // Actual Cart O/P
    Cart cart = new Cart(1, "Potato", 30, 2, 60, 7900001883L, "www.google.com");

    @Test
    public void getCartByIdTest() throws Exception {
        Mockito.when(cartService.getCartById(Mockito.anyLong())).thenReturn(cart);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc1.perform(requestBuilder).andReturn();
        String expectedCart = "{ 'id': 1, 'name': 'Potato', 'price': 30, 'quantity': 2,'totalPrice': 60, 'mobileNo': 7900001883, 'imageUrl': 'www.google.com' }";
        JSONAssert.assertEquals(expectedCart, result.getResponse().getContentAsString(), false);
    }


    // CREATING TEST CASES FOR USERSIGNUP AND LOGIN
    @Autowired
    private MockMvc mockMvc2;

    @MockBean
    private UserService userService;

    @BeforeEach
    public void setup2(){
        UserController controller = new UserController();
        controller.setUserService(userService);
        mockMvc2 = MockMvcBuilders.standaloneSetup(controller).build();
    }

    // ACTUAL O/P
    UserSignUp userSignUp = new UserSignUp("ambekarviks@gmail.com", "Vikas Ambekar", 7900001883L,
            "Vikas@4565", new Login(7900001883L, "ambekarviks@gmail.com", "Vikas@4565", "Success"));
    List<UserSignUp> userSignUps = new ArrayList<>();

    @Test
    public void getAllUsersTest() throws Exception {
        userSignUps.add(userSignUp);
        Mockito.when(userService.getAllUsers()).thenReturn(userSignUps);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc2.perform(requestBuilder).andReturn();

        String expectedUser = "{ 'email': 'ambekarviks@gmail.com', 'fullName': 'Vikas Ambekar', 'mobileNo': 7900001883, 'password': 'Vikas@4565', 'Login': {'mobileNo': 7900001883, 'email': 'ambekarviks@gmail.com', 'password': 'Vikas@4565', 'loginStatus': 'Success'}}";
        JSONAssert.assertEquals(expectedUser, result.getResponse().getContentAsString(), false);
    }

    @Autowired
    private MockMvc mockMvc3;

    @MockBean
    private AdminService adminService;

    @BeforeEach
    public void setup3(){
        AdminController controller = new AdminController();
        controller.setAdminService(adminService);
        mockMvc3 = MockMvcBuilders.standaloneSetup(controller).build();
    }

    AdminLogin adminLogin = new AdminLogin(7900001883L, "admin@gmail.com", "admin123", "Success");
    List<AdminLogin> adminLogins = new ArrayList<>();

    @Test
    public void getAllAdminTest() throws Exception {
        adminLogins.add(adminLogin);
        Mockito.when(adminService.getAllAdmin()).thenReturn( adminLogins);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admins").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc3.perform(requestBuilder).andReturn();
        String expectedAdmin = "[{ 'mobileNo': 7900001883, 'email': 'admin@gmail.com', 'password': 'admin123', 'loginStatus': 'Success'}]";
        JSONAssert.assertEquals(expectedAdmin, result.getResponse().getContentAsString(), false);
    }


}
