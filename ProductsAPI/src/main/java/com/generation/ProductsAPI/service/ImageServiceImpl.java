package com.generation.ProductsAPI.service;

import com.generation.ProductsAPI.model.Product;
import com.generation.ProductsAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService{

    private final ProductRepository productRepository;

    public ImageServiceImpl(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Save image in a local directory
    @Override
    public String uploadImageToFileSystem(MultipartFile imageFile) throws IOException {

        Path uploadPath = Paths.get("src/main/resources/static/image");

        String uniqueFileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();

        Path filePath = uploadPath.resolve(uniqueFileName);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Files.copy(imageFile.getInputStream(), filePath);



        return uniqueFileName;
    }

    // To view an image
    @Override
    public byte[] getImage(String imageName) throws IOException {
        Path imagePath = Paths.get("src/main/resources/static/image").resolve(imageName);

        if (Files.exists(imagePath)) {
            byte[] imageBytes = Files.readAllBytes(imagePath);
            return imageBytes;
        } else {
            return null; // Handle missing images
        }
    }

    // Delete an image
    @Override
    public void deleteImage(String imageName) throws IOException {
        Path imagePath = Paths.get("src/main/resources/static/image").resolve(imageName);

        Files.deleteIfExists(imagePath);
    }

//    @Override
//    public void deleteImage(Integer productId) throws IOException {
//
//        Optional<Product> result = productRepository.findById(productId);
//        Product product = result.get();
//
//
//        Path imagePath = Paths.get("../../image").resolve(product.getImage());
//
//        Files.deleteIfExists(imagePath);
//    }

}


