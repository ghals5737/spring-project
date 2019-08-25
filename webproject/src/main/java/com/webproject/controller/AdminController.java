package com.webproject.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webproject.domain.Category;
import com.webproject.domain.Order;
import com.webproject.domain.OrderDetail;
import com.webproject.domain.OrderList;
import com.webproject.domain.Product;
import com.webproject.domain.ProductView;
import com.webproject.domain.ReplyList;
import com.webproject.service.AdminService;
import com.webproject.utils.UploadFileUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONArray;



@Controller
@RequestMapping("/admin")
public class AdminController{
    private static final Logger logger=LoggerFactory.getLogger(UserController.class);
      
     @Autowired
     AdminService adminService;
    
     private String uploadPath="D:"+File.separator+"spring-project"+File.separator+"webproject"
     +File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static";
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public void getIndex()throws Exception{
        logger.info("get index");
    }

    @RequestMapping(value="/product/register", method=RequestMethod.GET)
    public void getProductRegiste(Model model)throws Exception {
        logger.info("get products register");        
        List<Category> category=null;
        category=adminService.category();          
        model.addAttribute("category", JSONArray.fromObject(category));
    }

    @RequestMapping(value = "/product/register", method=RequestMethod.POST)
    public String postProductRegister(Product product,MultipartFile file)throws Exception{
        
        String imgUploadPath = uploadPath + File.separator + "imgUpload";
        String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
        String fileName = null;       
        if(file.getOriginalFilename() != null && file.getOriginalFilename().compareTo("")!=0) {
         fileName =UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
         product.setPdImg(File.separator +"imgUpload" + ymdPath + File.separator + fileName);
         product.setPdThumbImg( File.separator+"imgUpload" + ymdPath+ File.separator + "s" +File.separator + "s_" + fileName); 
        } else {
         fileName = File.separator + "images" + File.separator + "none.png";
         product.setPdImg(fileName);
         product.setPdThumbImg(fileName);
        }      
        
        adminService.register(product);

        return "redirect:/admin/index";
    }
    
    @RequestMapping(value ="/product/list", method=RequestMethod.GET)
    public void getProductList(Model model)throws Exception{
        logger.info("get Product List");

        List<ProductView> list=adminService.productlist();

        model.addAttribute("list", list);
    }

    @RequestMapping(value = "/product/view", method=RequestMethod.GET)
    public void getProduct(@RequestParam("n")int pdNum,Model model)throws Exception{
        logger.info("get product view");

        ProductView product=adminService.getProductView(pdNum);

        model.addAttribute("product", product);
    }

    @RequestMapping(value="/product/modify", method=RequestMethod.GET)
    public void getProductModify(@RequestParam("n")int pdNum,Model model)throws Exception{
        logger.info("get product view");

        ProductView product=adminService.getProductView(pdNum);
        model.addAttribute("product", product);

        List<Category> category=null;
        category=adminService.category();          
        model.addAttribute("category", JSONArray.fromObject(category));
    }

    @RequestMapping(value="/product/modify", method=RequestMethod.POST)
    public String postProductModify(Product product,@RequestParam("n")int pdNum,MultipartFile file
       ,HttpServletRequest req)throws Exception{

        logger.info("get product view post");
        String pdImg=req.getParameter("pdImg");
        String pdThumbImg=req.getParameter("pdThumbImg");        
        // 새로운 파일이 등록되었는지 확인
        if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
            // 기존 파일을 삭제
            
            new File(uploadPath + pdImg).delete();
            new File(uploadPath + pdThumbImg).delete();
            
            // 새로 첨부한 파일을 등록
            String imgUploadPath = uploadPath + File.separator + "imgUpload";
            String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
            String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
           
            product.setPdImg(File.separator +"imgUpload" + ymdPath + File.separator + fileName);
            product.setPdThumbImg( File.separator+"imgUpload" + ymdPath+ File.separator + "s" +File.separator + "s_" + fileName);
            
            
        } else {  // 새로운 파일이 등록되지 않았다면
            // 기존 이미지를 그대로 사용
            product.setPdImg(pdImg);
            product.setPdThumbImg(pdThumbImg);
            
        }
        
   
        product.setPdNum(pdNum);
        adminService.productModify(product);
        
        return "redirect:/admin/index";
    }
    
    @RequestMapping(value = "/product/delete",method=RequestMethod.POST)
    public String postProductDelete(@RequestParam("n")int pdNum)throws Exception{
          logger.info("post product delete");

          adminService.productDelete(pdNum);

          return "redirect:/admin/index";
    }

    @RequestMapping(value = "/product/ckUpload", method = RequestMethod.POST)
    public void postCKEditorImgUpload(HttpServletRequest req,
            HttpServletResponse res,
            @RequestParam MultipartFile upload) throws Exception {
            logger.info("post CKEditor img upload");
    
            // 랜덤 문자 생성
            UUID uid = UUID.randomUUID();
            
            OutputStream out = null;
            PrintWriter printWriter = null;
            
            // 인코딩
            res.setCharacterEncoding("utf-8");
            res.setContentType("text/html;charset=utf-8");
            
            try {
            
            String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
            byte[] bytes = upload.getBytes();
            
            // 업로드 경로
            String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
            
            out = new FileOutputStream(new File(ckUploadPath));
            out.write(bytes);
            out.flush();  // out에 저장된 데이터를 전송하고 초기화
            
            String callback = req.getParameter("CKEditorFuncNum");
            printWriter = res.getWriter();
            String fileUrl = "/ckUpload/" + uid + "_" + fileName;  // 작성화면
        
            // 업로드시 메시지 출력
            printWriter.println("{\"filename\" : \""+callback+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");

            printWriter.flush();
            
            
            
            } catch (IOException e) { e.printStackTrace();
            } finally {
            try {
                if(out != null) { out.close(); }
                if(printWriter != null) { printWriter.close(); }
            } catch(IOException e) { e.printStackTrace(); }
            }
            
            return; 
        }
    // 주문 목록
    @RequestMapping(value = "/shop/orderList", method = RequestMethod.GET)
    public void getOrderList(Model model) throws Exception {
        logger.info("get admin order list ");
    
        List<Order> orderList = adminService.orderList();
    
        model.addAttribute("orderList", orderList);
    }

    // 주문 상세 목록
    @RequestMapping(value = "/shop/orderView", method = RequestMethod.GET)
    public void getOrderList(@RequestParam("n") String orderId,Model model) throws Exception {
        logger.info("get order view");

        List<OrderList> orderView = adminService.orderView(orderId);
        
        model.addAttribute("orderView", orderView);
    }

    // 주문 상세 목록 - 상태 변경
    @RequestMapping(value = "/shop/orderView", method = RequestMethod.POST)
    public String delivery(Order order) throws Exception {
        logger.info("post order view");
        
        adminService.delivery(order);
        
        List<OrderDetail> orderView=adminService.getOrderDetails(order);
        Product product=new Product();
 
        for(OrderDetail i:orderView){
            product.setPdNum(i.getPdNum());
            product.setPdStock(i.getCartStock());
            adminService.changeStock(product);
        }

        return "redirect:/admin/shop/orderView?n=" + order.getOrderId();
    }
    
    @GetMapping("/shop/allReply")
    public void getAllReply(Model model)throws Exception{
        logger.info("get all reply");

        List<ReplyList> reply=adminService.allReply();

        model.addAttribute("reply", reply);
    }
    
    @PostMapping("/shop/allReply")
    public String postAllReply(@RequestParam("repNum")int repNum)throws Exception{
        logger.info("post all reply");

        adminService.deleteReply(repNum);

        return "redirect:/admin/shop/allReply";
    }
}