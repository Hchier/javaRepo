package com.hand.api.controller.v1;

import com.hand.config.SwaggerApiConfig;
import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.hand.domain.entity.Item;
import com.hand.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@Api(tags = SwaggerApiConfig.ITEM)
@RestController("itemSiteController.v1")
//@RequestMapping("/v1/items")
public class ItemController extends BaseController {

    @Autowired
    private ItemRepository itemRepository;

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/items")
    public ResponseEntity<Page<Item>> list(Item item, @ApiIgnore @SortDefault(value = Item.FIELD_ITEM_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Item> list = itemRepository.pageAndSort(pageRequest, item);
        return Results.success(list);
    }

    @ApiOperation(value = "明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/{organizationId}/items")
    public ResponseEntity<Item> detail(@PathVariable("organizationId") Long organizationId,Long itemId) {
        Item item = itemRepository.selectByPrimaryKey(itemId);
        return Results.success(item);
    }

    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/v1/items")
    public ResponseEntity<Item> create(@RequestBody Item item) {
        validObject(item);
        itemRepository.insertSelective(item);
        return Results.success(item);
    }

    @ApiOperation(value = "修改")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping("/v1/items")
    public ResponseEntity<Item> update(@RequestBody Item item) {
        SecurityTokenHelper.validToken(item);
        itemRepository.updateByPrimaryKeySelective(item);
        return Results.success(item);
    }

    @ApiOperation(value = "删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping("/v1/items")
    public ResponseEntity<?> remove(@RequestBody Item item) {
        SecurityTokenHelper.validToken(item);
        itemRepository.deleteByPrimaryKey(item);
        return Results.success();
    }

}
