package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.atguigu.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

//    @Resource
//    private BrandService brandService;
//
//    @Resource
//    private CategoryService categoryService;
//
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;
//
//    @Resource
//    private AttrGroupDao attrGroupDao;
//
//    @Resource
//    private SkuSaleAttrValueDao skuSaleAttrValueDao;

    @Test
    public void testStringRedis() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("hello","world_" + UUID.randomUUID().toString());
        String hello = ops.get("hello");
        System.out.println("之前保存的数据:"+hello);
    }

    @Test
    public void testRedisson() {
        System.out.println(redissonClient);
    }

//    @Test
//    public void test1() {
//        List<SkuItemSaleAttrVo> saleAttrBySpuId = skuSaleAttrValueDao.getSaleAttrBySpuId(13L);
//        saleAttrBySpuId.forEach(System.out::println);
//    }
//
//    @Test
//    public void test() {
//        List<SpuItemAttrGroupVo> attrGroupWithAttrsBySpuId = attrGroupDao.getAttrGroupWithAttrsBySpuId(130L, 225L);
//        attrGroupWithAttrsBySpuId.forEach(System.out::println);
//    }
//


//    @Test
//    public void testFindPath() {
//        Long[] catelogPath = categoryService.findCatelogPath(225l);
//
//        log.info("完整路径catelogPath={}", Arrays.asList(catelogPath));
//    }

    @Autowired
    BrandService brandService;


    @Autowired
    CategoryService categoryService;
//
//    @Test
//    public void testFindPath(){
//        Long[] catelogPath = categoryService.findCatelogPath(225L);
//        log.info("完整路径：{}", Arrays.asList(catelogPath));
//    }




    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1L);
        brandEntity.setDescript("华为");

        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功....");

        brandService.updateById(brandEntity);

        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        list.forEach((item) -> {
            System.out.println(item);
        });
    }

    //    @Autowired
    //    private OSSClient ossClient;
    //
    //    @Test
    //    public void uploadFile() throws FileNotFoundException {
    //        String bucketName = "gulimall-2023";
    //        String objectName = "exampleobject3.png";
    //        String filePath= "C:\\Users\\Ken\\Desktop\\huawei.txt";
    //
    //        try {
    //            InputStream inputStream = new FileInputStream(filePath);
    //            ossClient.putObject(bucketName, objectName, inputStream);
    //        } catch (OSSException oe) {
    //            System.out.println("OSSException: " + oe.getErrorMessage());
    //        } catch (ClientException ce) {
    //            System.out.println("ClientException: " + ce.getMessage());
    //        } finally {
    //            if (ossClient != null) {
    //                ossClient.shutdown();
    //            }
    //        }
    //    }

}
