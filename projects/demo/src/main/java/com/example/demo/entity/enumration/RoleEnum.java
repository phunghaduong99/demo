package com.example.demo.entity.enumration;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;


@Getter
public enum RoleEnum {

    /**
     *   ADMINISTRATOR(Arrays.asList(
     *             Permission.READ_ONE_PRODUCT,
     *             Permission.READ_ALL_PRODUCTS,
     *             Permission.CREATE_ONE_PRODUCT,
     *             Permission.UPDATE_ONE_PRODUCT,
     *             Permission.DISABLE_ONE_PRODUCT,
     *             Permission.DELETE_ONE_PRODUCT,
     *             Permission.READ_ONE_CATEGORIES,
     *             Permission.READ_ALL_CATEGORIES,
     *             Permission.DISABLE_ONE_CATEGORIES,
     *             Permission.DELETE_ONE_CATEGORIES,
     *             Permission.CREATE_ONE_CATEGORIES,
     *             Permission.UPDATE_ONE_CATEGORIES,
     *             Permission.READ_MY_PROFILE
     *     )),
     */
    ROLE_ADMINISTRATOR(Arrays.asList(
            PermissionEnum.READ_ONE_PRODUCT,
            PermissionEnum.READ_ALL_PRODUCTS,
            PermissionEnum.CREATE_ONE_PRODUCT,
            PermissionEnum.UPDATE_ONE_PRODUCT,
            PermissionEnum.DISABLE_ONE_PRODUCT,
            PermissionEnum.DELETE_ONE_PRODUCT,
            PermissionEnum.READ_ONE_CATEGORIES,
            PermissionEnum.READ_ALL_CATEGORIES,
            PermissionEnum.DISABLE_ONE_CATEGORIES,
            PermissionEnum.DELETE_ONE_CATEGORIES,
            PermissionEnum.CREATE_ONE_CATEGORIES,
            PermissionEnum.UPDATE_ONE_CATEGORIES,
            PermissionEnum.READ_MY_PROFILE
    )),

    /**
     *    SELLER(Arrays.asList(
     *             Permission.READ_ONE_PRODUCT,
     *             Permission.READ_ALL_PRODUCTS,
     *             Permission.CREATE_ONE_PRODUCT,
     *             Permission.UPDATE_ONE_PRODUCT,
     *             Permission.READ_ALL_CATEGORIES,
     *             Permission.CREATE_ONE_CATEGORIES,
     *             Permission.UPDATE_ONE_CATEGORIES,
     *             Permission.READ_MY_PROFILE
     *     )),
     */
    ROLE_SELLER(Arrays.asList(
            PermissionEnum.READ_ONE_PRODUCT,
            PermissionEnum.READ_ALL_PRODUCTS,
            PermissionEnum.CREATE_ONE_PRODUCT,
            PermissionEnum.UPDATE_ONE_PRODUCT,
            PermissionEnum.READ_ALL_CATEGORIES,
            PermissionEnum.CREATE_ONE_CATEGORIES,
            PermissionEnum.UPDATE_ONE_CATEGORIES,
            PermissionEnum.READ_MY_PROFILE
    )),
    /**
     *   CUSTOMER(Arrays.asList(
     *             Permission.READ_MY_PROFILE
     *     ));
     */
    ROLE_CUSTOMER(Arrays.asList(
            PermissionEnum.READ_MY_PROFILE
    ));

    private List<PermissionEnum> permissions;

    RoleEnum(List<PermissionEnum> permissions) {
        this.permissions = permissions;
    }

}
