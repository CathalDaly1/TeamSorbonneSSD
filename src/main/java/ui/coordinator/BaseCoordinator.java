package ui.coordinator;

import ui.controller.ViewController;

abstract class BaseCoordinator {

    private ViewController currentViewController;

    void setFrameController(ViewController controller) {
        if (controller != null) {
            controller.show();
        }

        if (currentViewController != null) {
            currentViewController.hide();
        }

        currentViewController = controller;
    }
}
