/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.salesdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.salesdb.service.SalesService;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wordnik.swagger.annotations.*;
import com.salesdb.*;
import com.salesdb.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Controller object for domain model class Sales.
 * @see com.salesdb.Sales
 */
@RestController(value = "Salesdb.SalesController")
@RequestMapping("/salesdb/Sales")
@Api(value = "SalesController", description = "Exposes APIs to work with Sales resource.")
public class SalesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesController.class);

    @Autowired
    @Qualifier("salesdb.SalesService")
    private SalesService salesService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Sales instances matching the search criteria.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Sales> findSaless(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Saless list");
        return salesService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Sales instances.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Sales> getSaless(Pageable pageable) {
        LOGGER.debug("Rendering Saless list");
        return salesService.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setSalesService(SalesService service) {
        this.salesService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Sales instance.")
    public Sales createSales(@RequestBody Sales instance) {
        LOGGER.debug("Create Sales with information: {}", instance);
        instance = salesService.create(instance);
        LOGGER.debug("Created Sales with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Sales instances.")
    public Long countAllSaless() {
        LOGGER.debug("counting Saless");
        Long count = salesService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Sales instance associated with the given id.")
    public Sales getSales(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Sales with id: {}", id);
        Sales instance = salesService.findById(id);
        LOGGER.debug("Sales details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Sales instance associated with the given id.")
    public Sales editSales(@PathVariable("id") Integer id, @RequestBody Sales instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Sales with id: {}", instance.getId());
        instance.setId(id);
        instance = salesService.update(instance);
        LOGGER.debug("Sales details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Sales instance associated with the given id.")
    public boolean deleteSales(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Sales with id: {}", id);
        Sales deleted = salesService.delete(id);
        return deleted != null;
    }
}
