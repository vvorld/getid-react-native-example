//
//  RCTGetID.m
//  RNExample
//
//  Created by Mikhail Akopov on 16.12.2020.
//


#import "RCTGetID.h"
#import "AppDelegate.h"

@import GetID;

@implementation RCTGetID

RCT_EXPORT_MODULE(GetID);

RCT_EXPORT_METHOD(start:(NSString *)token url:(NSString *)url) {
  
  dispatch_async(dispatch_get_main_queue(), ^{
    [GIDFactory makeGetIDViewControllerWithToken:token url:url then:^(GetIDViewController *viewController, NSError *error) {
        if (error != nil) {
            return NSLog(@"%@", error.description);
        }
        AppDelegate *delegate = (AppDelegate *)[[UIApplication sharedApplication] delegate];
        [delegate.window.rootViewController presentViewController:viewController animated:YES completion:nil];
    }];
  });
}

@end

