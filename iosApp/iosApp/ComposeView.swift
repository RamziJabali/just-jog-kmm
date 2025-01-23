//
//  Untitled.swift
//  iosApp
//
//  Created by Ramzi Jabali on 10/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}
    
    func makeUIViewController(context: Context) -> some UIViewController {
        AppKt.MainViewController()
    }
}

