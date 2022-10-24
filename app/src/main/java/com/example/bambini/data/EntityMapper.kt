import com.example.bambini.data.ContentType
import com.example.bambini.entity.QuadroEntity
import com.example.bambini.entity.QuadroWithCategories

//package com.example.bambini.data
//
//import com.example.bambini.entity.*
//
//val Content.toLandingEntity: LandingEntities
//    get() = LandingEntities(data = content.map { type ->
//        when (type) {
//            is ContentType.BannerType -> type.data.asBannerEntity
//            is ContentType.QuadroType -> type.data.asQuadroWithCategoriesEntity
//            is ContentType.FeaturedCategoriesType -> type.data.asFeaturedCategoriesEntity
//            else -> throw IllegalArgumentException("no found any type")
//        }
//    })
//
//val ContentType.BannerType.BannerData.asBannerEntity: BannerEntity
//    get() = BannerEntity(
//        image = image
//    )
//
//val ContentType.FeaturedCategoriesType.FeaturedCategoriesData.asFeaturedCategoriesEntity: FeaturedCategories
//    get() = FeaturedCategories(
//        featuredCategories = categories.map {
//            FeaturedCategoryEntity(
//                title = it.title,
//                image = it.image.src
//            )
//        }
//    )

//val ContentType.QuadroType.QuadroData.asQuadroWithCategoriesEntity: QuadroWithCategories
//    get() = QuadroWithCategories(
//        quadro = asQuadroEntity,
//        quadroItems = categories.map(ContentType.QuadroType.QuadroCategoryItem::asQuadroItemEntity)
//    )
//
//val ContentType.QuadroType.QuadroData.asQuadroEntity: QuadroEntity
//    get() = QuadroEntity(
//        image = image.src,
//        title = title
//    )
//
//val ContentType.QuadroType.QuadroCategoryItem.asQuadroItemEntity: QuadroItemEntity
//    get() = QuadroItemEntity(
//        title = title,
//        image = image.src,
//        backgroundColor = backgroundColor,
//    )